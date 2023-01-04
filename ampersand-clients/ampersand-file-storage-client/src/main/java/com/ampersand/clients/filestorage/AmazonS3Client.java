package com.ampersand.clients.filestorage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Client implements FileStorageClient {
    private static final String FILE_URL = "%s%s";

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Value("${cloud.aws.s3.prefix}")
    private String prefix;

    private final AmazonS3 amazonS3;

    public FilePath upload(File file) {
        String fileName = file.getName();
        String uuid = UUID.randomUUID().toString();
        amazonS3.putObject(new PutObjectRequest(bucketName, uuid, file)
                .withCannedAcl(CannedAccessControlList.PublicRead)
                .withSdkRequestTimeout(5000)
                .withSdkClientExecutionTimeout(5000));
        cleanUp(file);
        return new FilePath(fileName, String.format(FILE_URL, prefix, uuid));
    }

    private void cleanUp(File file) {
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            log.error("Failed to delete file", e);
        }
    }
}
