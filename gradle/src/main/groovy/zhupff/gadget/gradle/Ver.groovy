package zhupff.gadget.gradle

final class Ver {
    private Ver() {}

    final static class Project {
        private Project() {}
        final static String MinSdkVersion = "24"
        final static String CompileSdkVersion = "32"
        final static String BuildGradleVersion = "7.1.1"
        final static String KotlinVersion = "1.7.10"
        final static String KspVersion = "1.7.10-1.0.6"
        final static String KotlinCompilerExtensionVersion = "1.3.1"
    }

    final static class Android {
        private Android() {}
        final static String AppCompat = "1.5.1"
        final static String ConstraintLayout = "2.0.0"
        final static String SwipeRefreshLayout = "1.1.0"
        final static String ViewPager2 = "1.0.0"
        final static String Lifecycle = "2.5.1"
        final static String DataStore = "1.0.0"
        final static String Material = "1.8.0"
    }

    final static class Google {
        private Google() {}
        final static String AutoService = "1.0"
        final static String Gson = "2.9.0"
    }

    final static class SquareUp {
        private SquareUp() {}
        final static String OkHttp = "4.10.0"
        final static String KotlinPoet = "1.9.0"
        final static String JavaPoet = "1.13.0"
        final static String Retrofit2 = "2.9.0"
    }

    final static String Glide = "4.13.0"
}