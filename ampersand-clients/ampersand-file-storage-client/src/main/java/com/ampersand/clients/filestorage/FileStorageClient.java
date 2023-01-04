package com.ampersand.clients.filestorage;

import java.io.File;

public interface FileStorageClient {
    FilePath upload(File file);
}
