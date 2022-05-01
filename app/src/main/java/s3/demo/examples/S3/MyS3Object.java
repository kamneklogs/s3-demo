package s3.demo.examples.S3;

import java.io.File;
import java.io.IOException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import s3.demo.logs.Loggable;
import s3.demo.storage.ObjectStorage;

public class MyS3Object extends ObjectStorage {

    private final AmazonS3 s3client;

    // @Value("${bucketName}")
    private final String bucketName;

    // @Value("${logPath}")
    private final String logPath;

    public MyS3Object() {
        s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_2)
                .build();

        bucketName = "kamneklogs";
        logPath = "analytics/logs/";
    }

    @Override
    public void save(Loggable log) {
        try {
            File file = toJsonFile(log);
            s3client.putObject(
                    bucketName,
                    logPath
                            + log.getClass().getSimpleName()
                            + "/" + file.getName(),
                    file);

            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
