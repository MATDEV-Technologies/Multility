// Currently not being used, but DO NOT DELETE

//package com.matdevtech.multility;
//
//import android.app.Activity;
//import android.app.Application;
//import android.content.Intent;
//
//public class UtilsTheme
//{
//    private static int sTheme;
//    public final static int THEME_DEFAULT = 0; // Green is the default
//    public final static int THEME_RED = 1;
//    public final static int THEME_ORANGE = 2;
//    public final static int THEME_YELLOW = 3;
//    public final static int THEME_BLUE = 4;
//    public final static int THEME_PURPLE = 5;
//    /**
//     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
//     */
//    public static void changeToTheme(Activity activity, int theme)
//    {
//        sTheme = theme;
//        activity.finish();
//        activity.startActivity(new Intent(activity, activity.getClass()));
//    }
//    /** Set the theme of the activity, according to the configuration. */
//    public static void onApplicationCreateSetTheme(Activity activity)
//    {
//        switch (sTheme)
//        {
//            default:
//            case THEME_DEFAULT:
//                activity.setTheme(R.style.AppTheme); // Green
//                break;
//            case THEME_RED:
//                activity.setTheme(R.style.AppThemeRed);
//                break;
//            case THEME_ORANGE:
//                activity.setTheme(R.style.AppThemeOrange);
//                break;
//            case THEME_YELLOW:
//                activity.setTheme(R.style.AppThemeYellow);
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