package services.showrooms;

import entities.Showroom;

import java.util.List;
import java.util.UUID;

public interface ShowroomService {
    public static final String NAME = "ShowroomService";

    List<Showroom> getAllShowrooms();

    Showroom getShowroomById(UUID id);

    void saveShowroom(Showroom showroom);

    void updateShowroom(Showroom showroom);

    void deleteShworoom(Showroom showroom);

    void fillShowroomFields(Showroom showroom, String name, String address, Integer capacity);
}
