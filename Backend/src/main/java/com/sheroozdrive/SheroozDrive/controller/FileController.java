package com.sheroozdrive.SheroozDrive.controller;

import com.sheroozdrive.SheroozDrive.model.File;
import com.sheroozdrive.SheroozDrive.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/files")
public class FileController implements SecuredRestController {

    private final FileService fileService;



    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("folder") String folderId,@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.uploadFile(folderId, file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getFile(@PathVariable String id) throws IOException {
        return fileService.getFile(id);
    }

    /*@GetMapping("/{id}")
    public File findById(@PathVariable String id) {
        return fileService.findById(id);
    }*/

    @GetMapping("/owner/{ownerId}")
    public List<File> findByOwnerId(@PathVariable String ownerId) {
        return fileService.findByOwnerId(ownerId);
    }

    @PostMapping
    public File create(@RequestBody File file) {
        return fileService.save(file);
    }

    @PutMapping
    public File update(@RequestBody File file) {
        return fileService.save(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        fileService.delete(id);
    }
}
