package cr.una.restaurant.backend.webservice;


import cr.una.restaurant.backend.comun.Constants;
import cr.una.restaurant.backend.dto.BillDto;
import cr.una.restaurant.backend.exception.BillNotFoundException;
import cr.una.restaurant.backend.model.Bill;
import cr.una.restaurant.backend.model.Dish;
import cr.una.restaurant.backend.service.IBillService;
import cr.una.restaurant.backend.service.IDishService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "bills")
public class BillController {

    @Autowired
    private IDishService serviceDishes;

    @Autowired
    private IBillService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    @ResponseBody
    public BillDto findById(@PathVariable Long id) throws BillNotFoundException {
        Bill bill = service.findById(id);
        return convertToDto(bill);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BillDto add(@Valid @RequestBody BillDto billDto) {
        Bill bill = convertToEntity(billDto);
        Bill billBD=service.add(bill);
        Dish newDish;
       /* for(int i=0; i<billDto.getDishes().size() ;i++){
            newDish=billDto.getDishes().get(i);
            newDish.setBill(billBD);
            serviceDishes.add(newDish);
        }*/
        return convertToDto(bill);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BillDto update(@Valid @RequestBody BillDto billDto) {
        Bill bill = convertToEntity(billDto);
        return convertToDto(service.update(bill));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (BillNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Bill Not Found", ex);
        }
    }

    /*Convert to Dto methods*/
    private BillDto convertToDto(Bill bill) {
        BillDto billDto = modelMapper.map(bill, BillDto.class);
        return billDto;
    }

    private Bill convertToEntity(BillDto billDto) {
        Bill bill = modelMapper.map(billDto, Bill.class);
        return bill;
    }
}
