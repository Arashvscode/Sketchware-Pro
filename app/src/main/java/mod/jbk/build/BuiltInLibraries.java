package mod.jbk.build;

import com.besome.sketch.SketchApplication;

import java.io.File;
import java.util.List;

import a.a.a.Jp;

public class BuiltInLibraries {

    // TODO: Maybe change location to cache directory
    private static final File EXTRACTED_BUILT_IN_LIBRARIES_PATH = new File(SketchApplication.getContext().getFilesDir(), "libs" + File.separator + "libs");
    private static final File EXTRACTED_BUILT_IN_LIBRARY_DEX_FILES_PATH = new File(SketchApplication.getContext().getFilesDir(), "libs" + File.separator + "dexs");

    // None final so that field values won't be optimized into code, and to allow easy changing of library names due to that

    public static String ANDROIDX_ACTIVITY = "activity-1.0.0";
    public static String ANDROIDX_ANNOTATION = "annotation-1.1.0";
    public static String ANDROIDX_ANNOTATION_EXPERIMENTAL = "annotation-experimental-1.1.0";
    public static String ANDROIDX_APPCOMPAT = "appcompat-1.0.0";
    public static String ANDROIDX_APPCOMPAT_RESOURCES = "appcompat-resources-1.1.0";
    public static String ANDROIDX_ASYNCLAYOUTINFLATER = "asynclayoutinflater-1.0.0";
    public static String ANDROIDX_BROWSER = "browser-1.0.0";
    public static String ANDROIDX_CARDVIEW = "cardview-1.0.0";
    public static String ANDROIDX_COLLECTION = "collection-1.0.0";
    public static String ANDROIDX_CONCURRENT_FUTURES = "concurrent-futures-1.1.0";
    public static String ANDROIDX_CONSTRAINTLAYOUT = "constraintlayout-2.1.2";
    public static String ANDROIDX_CONSTRAINTLAYOUT_CORE = "constraintlayout-core-1.0.2";
    public static String ANDROIDX_COORDINATORLAYOUT = "coordinatorlayout-1.0.0";
    public static String ANDROIDX_CORE = "core-1.0.0";
    public static String ANDROIDX_CORE_COMMON = "core-common-2.0.0";
    public static String ANDROIDX_CORE_KTX = "core-ktx-1.0.1";
    public static String ANDROIDX_CORE_RUNTIME = "core-runtime-2.0.0";
    public static String ANDROIDX_CURSORADAPTER = "cursoradapter-1.0.0";
    public static String ANDROIDX_CUSTOMVIEW = "customview-1.0.0";
    public static String ANDROIDX_DOCUMENTFILE = "documentfile-1.0.0";
    public static String ANDROIDX_DRAWERLAYOUT = "drawerlayout-1.0.0";
    public static String ANDROIDX_DYNAMIC_ANIMATION = "dynamic-animation-1.1.0";
    public static String ANDROIDX_EMOJI2 = "emoji2-1.0.1";
    public static String ANDROIDX_EMOJI2_VIEWS_HELPER = "emoji2-views-helper-1.0.1";
    public static String ANDROIDX_EXIFINTERFACE = "exifinterface-1.0.0";
    public static String ANDROIDX_FRAGMENT = "fragment-1.0.0";
    public static String ANDROIDX_INTERPOLATOR = "interpolator-1.0.0";
    public static String ANDROIDX_LEGACY_SUPPORT_CORE_UI = "legacy-support-core-ui-1.0.0";
    public static String ANDROIDX_LEGACY_SUPPORT_CORE_UTILS = "legacy-support-core-utils-1.0.0";
    public static String ANDROIDX_LEGACY_SUPPORT_V4 = "legacy-support-v4-1.0.0";
    public static String ANDROIDX_LEGACY_SUPPORT_V13 = "legacy-support-v13-1.0.0";
    public static String ANDROIDX_LIFECYCLE_COMMON = "lifecycle-common-2.0.0";
    public static String ANDROIDX_LIFECYCLE_LIVEDATA = "lifecycle-livedata-2.0.0";
    public static String ANDROIDX_LIFECYCLE_LIVEDATA_CORE = "lifecycle-livedata-core-2.0.0";
    public static String ANDROIDX_LIFECYCLE_PROCESS = "lifecycle-process-2.4.0";
    public static String ANDROIDX_LIFECYCLE_RUNTIME = "lifecycle-runtime-2.0.0";
    public static String ANDROIDX_LIFECYCLE_VIEWMODEL = "lifecycle-viewmodel-2.0.0";
    public static String ANDROIDX_LIFECYCLE_VIEWMODEL_SAVEDSTATE = "lifecycle-viewmodel-savedstate-2.3.1";
    public static String ANDROIDX_LISTENABLEFUTURE = "listenablefuture-1.0.0";
    public static String ANDROIDX_LOADER = "loader-1.0.0";
    public static String ANDROIDX_LOCALBROADCASTMANAGER = "localbroadcastmanager-1.0.0";
    public static String ANDROIDX_MEDIA = "media-1.0.0";
    public static String ANDROIDX_MULTIDEX = "multidex-2.0.1";
    public static String ANDROIDX_PRINT = "print-1.0.0";
    public static String ANDROIDX_RECYCLERVIEW = "recyclerview-1.0.0";
    public static String ANDROIDX_RESOURCEINSPECTION_ANNOTATION = "resourceinspection-annotation-1.0.0";
    public static String ANDROIDX_SAVEDSTATE = "savedstate-1.0.0";
    public static String ANDROIDX_SLIDINGPANELAYOUT = "slidingpanelayout-1.0.0";
    public static String ANDROIDX_STARTUP_RUNTIME = "startup-runtime-1.1.0";
    public static String ANDROIDX_SWIPEREFRESHLAYOUT = "swiperefreshlayout-1.0.0";
    public static String ANDROIDX_TRACING = "tracing-1.0.0";
    public static String ANDROIDX_TRANSITION = "transition-1.0.0";
    public static String ANDROIDX_VECTORDRAWABLE = "vectordrawable-1.0.0";
    public static String ANDROIDX_VECTORDRAWABLE_ANIMATED = "vectordrawable-animated-1.0.0";
    public static String ANDROIDX_VERSIONEDPARCELABLE = "versionedparcelable-1.0.0";
    public static String ANDROIDX_VIEWPAGER2 = "viewpager2-1.0.0";
    public static String ANDROIDX_VIEWPAGER = "viewpager-1.0.0";
    public static String ANDROIDX_WORK_RUNTIME = "work-runtime-2.1.0";
    public static String FIREBASE_AUTH = "firebase-auth-19.0.0";
    public static String FIREBASE_AUTH_INTEROP = "firebase-auth-interop-18.0.0";
    public static String FIREBASE_COMMON = "firebase-common-19.0.0";
    public static String FIREBASE_DATABASE = "firebase-database-19.0.0";
    public static String FIREBASE_DATABASE_COLLECTION = "firebase-database-collection-17.0.0";
    public static String FIREBASE_DYNAMIC_LINKS = "firebase-dynamic-links-19.0.0";
    public static String FIREBASE_IID = "firebase-iid-19.0.0";
    public static String FIREBASE_IID_INTEROP = "firebase-iid-interop-17.0.0";
    public static String FIREBASE_MEASUREMENT_CONNECTOR = "firebase-measurement-connector-18.0.0";
    public static String FIREBASE_MESSAGING = "firebase-messaging-19.0.0";
    public static String FIREBASE_STORAGE = "firebase-storage-19.0.0";
    public static String CIRCLE_IMAGEVIEW = "circle-imageview-v3.1.0";
    public static String CODE_VIEW = "code-view";
    public static String FACEBOOK_ADS_AUDIENCE_NETWORK_SDK = "audience-network-sdk-5.9.0";
    public static String GLIDE_ANNOTATIONS = "annotations-4.11.0";
    public static String GLIDE_DISKLRUCACHE = "disklrucache-4.11.0";
    public static String GLIDE_GIFDECODER = "gifdecoder-4.11.0";
    public static String GLIDE = "glide-4.11.0";
    public static String GOOGLE_AUTO_VALUE_ANNOTATIONS = "auto-value-annotations-1.6.5";
    public static String GSON = "gson-2.8.0";
    public static String HTTP_LEGACY_ANDROID_28 = "http-legacy-android-28";
    public static String JAVAX_INJECT = "javax-inject-1";
    public static String JETBRAINS_ANNOTATIONS = "annotations-13.0";
    public static String KOTLIN_STDLIB = "kotlin-stdlib-1.3.50";
    public static String KOTLIN_STDLIB_JDK7 = "kotlin-stdlib-jdk7-1.3.50";
    public static String LOTTIE = "Lottie-3.4.0";
    public static String MATERIAL = "material-1.0.0";
    public static String OKHTTP = "okhttp-3.9.1";
    public static String OKIO = "Okio-1.17.4";
    public static String ONESIGNAL = "OneSignal-3.14.0";
    public static String OTPVIEW = "OTPView-0.1.0";
    public static String PATTERN_LOCK_VIEW = "pattern-lock-view";
    public static String PLAY_SERVICES_ADS = "play-services-ads-18.2.0";
    public static String PLAY_SERVICES_ADS_BASE = "play-services-ads-base-18.2.0";
    public static String PLAY_SERVICES_ADS_IDENTIFIER = "play-services-ads-identifier-17.0.0";
    public static String PLAY_SERVICES_ADS_LITE = "play-services-ads-lite-18.2.0";
    public static String PLAY_SERVICES_AUTH = "play-services-auth-17.0.0";
    public static String PLAY_SERVICES_AUTH_API_PHONE = "play-services-auth-api-phone-17.0.0";
    public static String PLAY_SERVICES_AUTH_BASE = "play-services-auth-base-17.0.0";
    public static String PLAY_SERVICES_BASE = "play-services-base-17.1.0";
    public static String PLAY_SERVICES_BASEMENT = "play-services-basement-17.0.0";
    public static String PLAY_SERVICES_GASS = "play-services-gass-18.2.0";
    public static String PLAY_SERVICES_GCM = "play-services-gcm-17.0.0";
    public static String PLAY_SERVICES_IID = "play-services-iid-17.0.0";
    public static String PLAY_SERVICES_LOCATION = "play-services-location-17.0.0";
    public static String PLAY_SERVICES_MAPS = "play-services-maps-17.0.0";
    public static String PLAY_SERVICES_MEASUREMENT = "play-services-measurement-17.0.0";
    public static String PLAY_SERVICES_MEASUREMENT_BASE = "play-services-measurement-base-17.0.0";
    public static String PLAY_SERVICES_MEASUREMENT_IMPL = "play-services-measurement-impl-17.0.0";
    public static String PLAY_SERVICES_MEASUREMENT_SDK = "play-services-measurement-sdk-17.0.0";
    public static String PLAY_SERVICES_MEASUREMENT_SDK_API = "play-services-measurement-sdk-api-17.0.0";
    public static String PLAY_SERVICES_PLACES_PLACEREPORT = "play-services-places-placereport-17.0.0";
    public static String PLAY_SERVICES_STATS = "play-services-stats-17.0.0";
    public static String PLAY_SERVICES_TASKS = "play-services-tasks-17.0.0";
    public static String WAVE_SIDE_BAR = "wave-side-bar";
    public static String YOUTUBE_PLAYER = "android-youtube-player-10.0.5";

    public static File getLibraryPath(String libraryName) {
        return new File(EXTRACTED_BUILT_IN_LIBRARIES_PATH, libraryName);
    }

    public static String getLibraryPathString(String libraryName) {
        return getLibraryPath(libraryName).getAbsolutePath();
    }

    public static File getLibraryClassesJarPath(String libraryName) {
        return new File(getLibraryPath(libraryName), "classes.jar");
    }

    public static String getLibraryClassesJarPathString(String libraryName) {
        return getLibraryClassesJarPath(libraryName).getAbsolutePath();
    }

    public static File getLibraryDexFile(String libraryName) {
        return new File(EXTRACTED_BUILT_IN_LIBRARY_DEX_FILES_PATH, libraryName + ".dex");
    }

    public static String getLibraryDexFilePath(String libraryName) {
        return new File(EXTRACTED_BUILT_IN_LIBRARY_DEX_FILES_PATH, libraryName + ".dex").getAbsolutePath();
    }

    /**
     * @throws IllegalArgumentException Thrown if the specified library doesn't have any assets.
     */
    public static File getLibraryAssets(String libraryName) {
        Jp library = new Jp(libraryName);

        if (library.d()) {
            return new File(EXTRACTED_BUILT_IN_LIBRARIES_PATH, libraryName + File.separator + "assets");
        } else {
            throw new IllegalArgumentException("Built-in library '" + libraryName + "' doesn't have any assets.");
        }
    }

    /**
     * @throws IllegalArgumentException Thrown if the specified library doesn't have any assets.
     */
    public static String getLibraryAssetsPath(String libraryName) {
        return getLibraryAssets(libraryName).getAbsolutePath();
    }

    public static File getLibraryResources(String libraryName) {
        Jp library = new Jp(libraryName);

        if (library.c()) {
            return new File(EXTRACTED_BUILT_IN_LIBRARIES_PATH, libraryName + File.separator + "res");
        } else {
            throw new IllegalArgumentException("Built-in library '" + libraryName + "' doesn't have any resources.");
        }
    }

    public static String getLibraryResourcesPath(String libraryName) {
        return getLibraryResources(libraryName).getAbsolutePath();
    }
}
