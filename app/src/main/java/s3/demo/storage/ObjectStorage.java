package s3.demo.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.google.gson.Gson;

import s3.demo.logs.Loggable;

public abstract class ObjectStorage {

    public abstract void save(Loggable log);

    public static File toJsonFile(Loggable log) throws IOException {
        String payload = new Gson().toJson(log);
        File output = new File(getFileName(log));
        FileWriter writer = new FileWriter(output);

        writer.write(payload);
        writer.flush();
        writer.close();
        return output;
    }

    public static String getFileName(Loggable log) {
        StringBuilder sb = new StringBuilder();

        sb.append(log.getClass().getSimpleName())
                .append("-")
                .append(getDataTime())
                .append("-")
                .append(UUID.randomUUID())
                .append(".json");

        return sb.toString();
    }

    public static String getDataTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return dtf.format(LocalDateTime.now());
    }
}
