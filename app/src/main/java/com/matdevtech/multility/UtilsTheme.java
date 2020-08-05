//// Currently not being used, but DO NOT DELETE
//
//package com.matdevtech.multility;
//
//// Imports
//import android.app.Activity;
//import android.content.Intent;
//
//// Main class
//public class UtilsTheme
//{
//    // Global variables in the class (public accessible anywhere, private only to the class)
//    // Integer theme variables are constants, so they cannot be changed and by convention are all uppercase
//    private static int sTheme;
//    public final static int THEME_DEFAULT = 0; // Green is the default
//    public final static int THEME_RED = 1;
//    public final static int THEME_ORANGE = 2;
//    public final static int THEME_YELLOW = 3;
//    public final static int THEME_GREEN = 4;
//    public final static int THEME_BLUE = 5;
//    public final static int THEME_PURPLE = 6;
//
//    // Set the theme of the Activity, and restart it by  creating a new Activity of the same type
//    @SuppressWarnings("unused")
//    public static void changeToTheme(Activity activity, int theme)
//    {
//        sTheme = theme;
//        activity.finish();
//        activity.startActivity(new Intent(activity, activity.getClass()));
//    }
//
//    // Set the theme of the activity, according to the configuration
//    public static void onActivityCreateSetTheme(Activity activity, int sTheme)
//    {
//        // Switch statement as a substitute for an if-else if-else chain if there are a bigger amount of conditions
//        // Checks for each theme form the selection and sets it accordingly
//        switch (sTheme)
//        {
//            default:
//            case THEME_DEFAULT:
//                activity.setTheme(R.style.AppTheme); // Green
//                break; // GLOBAL NOTE: All switch statements break by convention so that following branches don't get executed accidentally
//            case THEME_RED:
//                activity.setTheme(R.style.AppThemeRed);
//                break;
//            case THEME_ORANGE:
//                activity.setTheme(R.style.AppThemeOrange);
//                break;
//            case THEME_YELLOW:
//                activity.setTheme(R.style.AppThemeYellow);
//                break;
//            case THEME_GREEN:
//                activity.setTheme(R.style.AppThemeGreen);
//                break;
//            case THEME_BLUE:
//                activity.setTheme(R.style.AppThemeBlue);
//                break;
//            case THEME_PURPLE:
//                activity.setTheme(R.style.AppThemePurple);
//                break;
//        }
//    }
//}