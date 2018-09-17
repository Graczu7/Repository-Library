package dto;

import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class BorrowDto {

    @NotNull
    private Long bookId;

    @NotNull
    private Long borrowerId;
}
