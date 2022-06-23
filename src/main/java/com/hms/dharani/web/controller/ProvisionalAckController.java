package com.hms.dharani.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.dharani.persistence.entity.ProvisionalAck;
import com.hms.dharani.web.service.ProvisionalAckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
public class ProvisionalAckController {

    @Autowired
    private ProvisionalAckService provisionalAckService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/addProv")
    public String store(@ModelAttribute("provisionalAck") ProvisionalAck provisionalAck) {
        provisionalAck.setDate(new Date());
        provisionalAck.setTime(new Time(System.currentTimeMillis()));
        provisionalAckService.store(provisionalAck);
        return "redirect:/addProv";
        // return new ResponseEntity<ProvisionalAck>(, HttpStatus.OK);
    }

    @GetMapping("/getAllProv")
    public ResponseEntity<List<ProvisionalAck>> getAll() {
        return new ResponseEntity<List<ProvisionalAck>>(provisionalAckService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/capture")
    public ResponseEntity<String> takeCapture(@RequestParam("image") MultipartFile multipartFile)
            throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String uploadDir = "python/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        StringBuilder result = new StringBuilder();
        String line;
        String name = System.currentTimeMillis() + "_" + fileName;
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(name);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            ProcessBuilder builder = new ProcessBuilder(
                    "python", "H:\\HMS\\python\\image_converter.py", "H:\\HMS\\python\\" + name);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                result.append(line);

            }
            //
            ProvisionalAck provisionalAck = objectMapper.readValue(result.toString(), ProvisionalAck.class);
            provisionalAckService.store(provisionalAck);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }

        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
}
