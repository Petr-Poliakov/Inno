package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("ift.properties")) {
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить ift.properties", e);
        }
    }

    public static String standUrl() {
        return properties.getProperty("ift.url");
    }

    public static String apiUrl() {
        return properties.getProperty("api.url");
    }

    public static int elementTimeoutMs() {
        return Integer.parseInt(properties.getProperty("element.timeout"));
    }

    public static String logLevel() {
        return properties.getProperty("log.level");
    }

    public static String adminLogin() {
        return properties.getProperty("admin.login");
    }

    public static String adminPassword() {
        return properties.getProperty("admin.password");
    }

    public static String defProductName() {
        return properties.getProperty("product.name");
    }

    public static double defProductPrice() {
        return Double.parseDouble(properties.getProperty("product.price"));
    }

    // Печатаем в консоль все параметры, без пары логин, пароль
    public static void printConfig() {
        System.out.println("======================================");
        System.out.println("Конфигурация запуска: ");
        System.out.println("Stand URL: " + standUrl());
        System.out.println("API URL: " + apiUrl());
        System.out.println("Element timeout (ms): " + elementTimeoutMs());
        System.out.println("Log level: " + logLevel());
        System.out.println("Дефолтный товар: " + defProductName() + ", цена: " + defProductPrice());
        System.out.println("=======================================");
    }
}