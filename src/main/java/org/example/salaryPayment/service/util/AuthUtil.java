package org.example.salaryPayment.service.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static String getPrincipalName() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        return  (auth != null) ? auth.getName(): null;

    }
}
