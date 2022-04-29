package s3.demo;

import s3.demo.examples.S3.S3TrainingObject;
import s3.demo.examples.logs.ExamViewLog;
import s3.demo.examples.logs.ProfileViewLog;
import s3.demo.logs.Loggable;
import s3.demo.storage.ObjectStorage;

public class App {

    static ObjectStorage s3 = new S3TrainingObject();

    public static void main(String[] args) {
        Loggable log = new ProfileViewLog("el nombre", "la data");
        Loggable log2 = new ExamViewLog("el nombre", "la data");

        s3.save(log);
        s3.save(log2);
    }
}