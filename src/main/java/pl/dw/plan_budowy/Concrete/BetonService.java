package pl.dw.plan_budowy.Concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BetonService {

    private final BetonRepository betonRepository;

    @Autowired
    public BetonService(BetonRepository betonRepository) {
        this.betonRepository = betonRepository;
    }

    //działa
    public List<BetonEntity> getAll(String direction) {
        Sort sort;
        if ("asc".equals(direction)) {
            sort = Sort.by(Sort.Direction.ASC,"klasa");
        } else if ("desc".equals(direction)) {
            sort = Sort.by(Sort.Direction.DESC,"klasa");
        } else {
            sort = Sort.unsorted();
        }
        return betonRepository.findAll(sort);
    }

    BetonEntity getById(String element) {
        return betonRepository.findById(element)
                .orElseThrow(()->{
                    throw new NoSuchElementException();
                });
    }

    //nie działą
    BetonEntity getById2(String klasa) {
        return betonRepository.findById(klasa)
                .orElseThrow(()->{
                    throw new NoSuchElementException();
                });
    }

    public BetonEntity add(BetonEntity betonEntity) {
        betonRepository.findById(betonEntity.getElement())
                .ifPresent((o)->{
                    throw new IllegalArgumentException();
                });
        return betonRepository.save(betonEntity);
    }

    // działa parametr taki jak podany w interface BetonRepository
    public BetonEntity delete(String betonDoUsuniecia) {
         BetonEntity betonEntity = betonRepository.findById(betonDoUsuniecia)
                .orElseThrow(()-> {
                    throw new NoSuchElementException();
                });
        betonRepository.delete(betonEntity);
        return betonEntity;
    }

    public BetonEntity update(BetonEntity betonEntityDoAktualizacji) {
        BetonEntity betonEntity = betonRepository.findById(betonEntityDoAktualizacji.getElement())
                .orElseThrow(()-> {
                    throw new NoSuchElementException();
                });
        betonEntity.setQuantity(betonEntityDoAktualizacji.getQuantity());
        betonEntity.setStartTime(betonEntityDoAktualizacji.getStartTime());
        betonEntity.setKlasa(betonEntityDoAktualizacji.getKlasa());
        return betonRepository.save(betonEntity);
    }
}
