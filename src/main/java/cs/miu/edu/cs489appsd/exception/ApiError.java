package cs.miu.edu.cs489appsd.exception;

import java.time.Instant;

public record ApiError(
        String message,
        String path,
        Integer statusCode,
        Instant timeStamp
) {

}
