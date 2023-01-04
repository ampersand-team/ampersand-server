package com.ampersand.clients.filestorage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilePath {
    private final String fileName;

    private final String fileUrl;
}
