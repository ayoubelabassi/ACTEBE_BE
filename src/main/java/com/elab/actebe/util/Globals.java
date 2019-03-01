package com.elab.actebe.util;

public class Globals {

    /**
     * Security Constants
     */
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user/sign-up";

    /**
     * Profile Modes
     */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    /**
     * Reporting Constants
     */
    public static enum FileFormat {
        PDF,
        XLS
    }

    /**
     * Project files KEYS
     */
    public static String WORK_DIRECTORY="work.directory";
}
