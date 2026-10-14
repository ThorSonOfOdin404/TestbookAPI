package in.prathamattri.testbookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRequestDTO {
    private String title;
    private String author;
    private double price;
}
