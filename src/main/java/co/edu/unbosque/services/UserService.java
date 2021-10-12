package co.edu.unbosque.services;

import co.edu.unbosque.dtos.User;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class UserService {

    public static Optional<List<User>> getListOfCountries() throws IOException {

        List<User> users;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("countries.csv")) {
            if (is == null) {
                return Optional.empty();
            }

            HeaderColumnNameMappingStrategy<User> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(User.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(br)
                        .withType(User.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                users = csvToBean.parse();
                System.out.println(users);
            }
        }
        return Optional.of(users);
    }
}