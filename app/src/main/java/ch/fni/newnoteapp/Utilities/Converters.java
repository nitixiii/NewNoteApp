package ch.fni.newnoteapp.Utilities;

import android.net.Uri;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

import ch.fni.newnoteapp.models.FileType;

/**
 * Converter class for LocalDateTime objects.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
public class Converters {

    // --- DATETIME <-> LONG ---

    /**
     * Converts LocalDateTime to milliseconds of type long (Reference --> milliseconds from 1970-01-01).
     * @param dateTime Local date and time to convert in milliseconds
     * @return  Time in milliseconds (long)
     * @throws NullPointerException
     */
    @TypeConverter
    public static long fromDateTime(LocalDateTime dateTime) throws NullPointerException {
        return dateTime == null ? null : dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Converts milliseconds (long) in LocalDateTime object
     * @param millis Time passed in milliseconds from 1970-01-01
     * @return Local date and time (LocalDateTime)
     */
    @TypeConverter
    public static LocalDateTime fromLong(long millis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), TimeZone.getDefault().toZoneId());
    }


    // --- ENUM<FILETYPE> <-> INT ---


    /**
     * Converts the enum (FileType) in a number (ordinal int).
     * @param fileType Enum to convert in a number
     * @return Number/ordinal (int)
     */
    @TypeConverter
    public static int fromEnumFileType(Enum<FileType> fileType) {
        return fileType == FileType.NONE ? 0 : fileType.ordinal();
    }

    /**
     * Converts a number in a enum of FileType.
     * @param ordinal Number to convert in a FileType
     * @return FileType (Enum)
     */
    @TypeConverter
    public static Enum<FileType> fromOrdinalInt(int ordinal) {
        switch(ordinal) {
            case 0: return FileType.NONE;
            case 1: return FileType.PICTURE;
            case 2: return FileType.AUDIO;
            default: return FileType.OTHER;
        }
    }


    // --- URI <-> STRING ---

    /**
     * Converts a Uri into a String
     * @param uri Uri to convert in a String
     * @return String of Uri
     */
    @TypeConverter
    public static String fromUri(Uri uri) {
        return uri == null ? Uri.EMPTY.toString() : uri.toString();
    }

    /**
     * Converts a String to an Uri object
     * @param uriString String to convert in an Uri
     * @return Uri (Uri) from String
     */
    @TypeConverter
    public static Uri fromString(String uriString) {
        return uriString.isEmpty() ? Uri.EMPTY : Uri.parse(uriString);
    }
}
