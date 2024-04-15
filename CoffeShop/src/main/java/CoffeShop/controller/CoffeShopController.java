package CoffeShop.controller;

import CoffeShop.entity.Barista;
import CoffeShop.entity.Buyer;
import CoffeShop.entity.Goods;
import CoffeShop.entity.Menu;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BaristaRepository;
import repository.BuyerRepository;
import repository.GoodsRepository;
import repository.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/api/coffeeshop")
public class CoffeShopController {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private MenuRepository menuRepository;



    @GetMapping("/buyers")
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @PostMapping("/buyers")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @GetMapping("/buyers/{id}")
    public Buyer getBuyerById(@PathVariable Long id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer"));
    }

    @PutMapping("/buyers/{id}")
    public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer buyerDetails) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer"));

        buyer.setName(buyerDetails.getName());

        return buyerRepository.save(buyer);
    }

    @DeleteMapping("/buyers/{id}")
    public ResponseEntity<?> deleteBuyer(@PathVariable Long id) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer"));

        buyerRepository.delete(buyer);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/goods")
    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    @PostMapping("/goods")
    public Goods createGoods(@RequestBody Goods goods) {
        return goodsRepository.save(goods);
    }

    @GetMapping("/goods/{id}")
    public Goods getGoodsById(@PathVariable Long id) {
        return goodsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goods"));
    }

    @PutMapping("/goods/{id}")
    public Goods updateGoods(@PathVariable Long id, @RequestBody Goods goodsDetails) {
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goods"));

        goods.setName(goodsDetails.getName());
        goods.setCost(goodsDetails.getCost());
        goods.setQuantity(goodsDetails.getQuantity());

        return goodsRepository.save(goods);
    }

    @DeleteMapping("/goods/{id}")
    public ResponseEntity<?> deleteGoods(@PathVariable Long id) {
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goods"));

        goodsRepository.delete(goods);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/baristas")
    public List<Barista> getAllBaristas() {
        return baristaRepository.findAll();
    }

    @PostMapping("/baristas")
    public Barista createBarista(@RequestBody Barista barista) {
        return baristaRepository.save(barista);
    }

    @GetMapping("/baristas/{id}")
    public Barista getBaristaById(@PathVariable Long id) {
        return baristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barista"));
    }

    @PutMapping("/baristas/{id}")
    public Barista updateBarista(@PathVariable Long id, @RequestBody Barista baristaDetails) {
        Barista barista = baristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barista"));

        barista.setFullName(baristaDetails.getFullName());
        barista.setJobTitle(baristaDetails.getJobTitle());
        ((Barista) barista).setExperience(baristaDetails.getExperience());

        return baristaRepository.save(barista);
    }

    @DeleteMapping("/baristas/{id}")
    public ResponseEntity<?> deleteBarista(@PathVariable Long id) {
        Barista barista = baristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barista"));

        baristaRepository.delete(barista);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/menu")
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @PostMapping("/menu")
    public Menu createMenu(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @GetMapping("/menu/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu"));
    }

    @PutMapping("/menu/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu"));

        return menuRepository.save(menu);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu"));

        menuRepository.delete(menu);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/menu/{positionId}/quantity")
    public String getPositionQuantity(@PathVariable Long positionId) {
        Menu menu = menuRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu"));
        return "Position: " + ((Menu) menu).getGoods().getName() + ", Quantity: " + menu.getGoods().getQuantity();
    }


    @GetMapping("/buyers/{buyerId}/popular")
    public String getPopularPositionForBuyer(@PathVariable Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer"));

        return "Buyer: " + buyer.getName() + ", Popular Position: флатте ватте";
    }
}
