package pl.dw.plan_budowy.Concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("beton")
@RestController
public class BetonController {
    private final BetonService betonService;

    @Autowired
    public BetonController(BetonService betonService) {
        this.betonService = betonService;
    }

    @GetMapping
    public List<BetonEntity> getAll(@RequestParam(required = false) String direction){
        return betonService.getAll(direction);
    }

    @GetMapping("/{element}")
    BetonEntity getByElement(@PathVariable String element){
        return betonService.getById(element);
    }

    //nie działa
    @GetMapping("/{klasa}")
    BetonEntity getByKlasa(@PathVariable String klasa){
        return betonService.getById2(klasa);
    }

    @PostMapping
    public BetonEntity add(@Valid @RequestBody BetonEntity betonEntity) {
        return betonService.add(betonEntity);
    }

    @DeleteMapping("/{element}")
    public BetonEntity delete(@PathVariable String element){
        return betonService.delete(element);
    }

    @PutMapping
    public BetonEntity update(@RequestBody BetonEntity betonEntity){
        return betonService.update(betonEntity);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Object> handleException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
