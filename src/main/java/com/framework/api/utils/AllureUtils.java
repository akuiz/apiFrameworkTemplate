package com.framework.api.utils;

import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachment, String message) {
        return message;
    }
}
