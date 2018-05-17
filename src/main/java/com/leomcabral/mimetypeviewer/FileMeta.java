package com.leomcabral.mimetypeviewer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Leonardo de M. Cabral (leomcabral at gmail.com)
 */
public class FileMeta {

    private final File file;
    private final String fileName;
    private final String mime;

    public FileMeta(File file) {
        this.file = file;
        this.fileName = this.file.getName();
        Path path = Paths.get(this.file.toURI());
        String _mime;
        try {
            _mime = Files.probeContentType(path);
        } catch (IOException ex) {
            _mime = "ERROR";
        }
        this.mime = _mime;
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMime() {
        return mime;
    }

}
