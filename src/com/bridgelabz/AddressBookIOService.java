package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class AddressBookIOService {
    private static final String FILE_NAME = "Contact-Details.txt";

    public void writeContactInfo(Map<String, List<ContactInfo>> addressBooks) {
        Path path = Paths.get(FILE_NAME);
        StringBuilder contactInfoBuilder = new StringBuilder();
        addressBooks.keySet()
                .forEach(keyOfBook -> {
                    contactInfoBuilder.append("\n")
                            .append(keyOfBook)
                            .append(" --->\n");
                    addressBooks.get(keyOfBook)
                            .forEach(contactInfo -> {
                                String line = contactInfo.toString();
                                contactInfoBuilder.append(line);
                            });
                });
        try {
            Files.deleteIfExists(path);
            Files.write(path, contactInfoBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
