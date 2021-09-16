package co.com.poli.users.models;


import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private Long id;
    private Long userid;
    private Long showtimeid;
    private List<Long> movies_id;
}
