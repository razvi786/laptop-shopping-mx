package com.shopping.laptopshopping.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.laptopshopping.entity.WishList;
import com.shopping.laptopshopping.service.WishListService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class WishListResource {

  @Autowired WishListService wishListService;

  @GetMapping("wishList")
  public List<WishList> getWishLists() {
    return wishListService.getAllWishLists();
  }

  @GetMapping("wishList/{id}")
  public WishList getWishListById(@PathVariable("id") Integer id) {
    return wishListService.getWishListById(id);
  }

  @PostMapping("wishList")
  public WishList saveWishList(@RequestBody WishList wishList) {
    return wishListService.saveOrUpdateWishList(wishList);
  }

  @PutMapping("wishList")
  public WishList updateWishList(@RequestBody WishList wishList) {
    return wishListService.saveOrUpdateWishList(wishList);
  }

  @DeleteMapping("wishList/{id}")
  public boolean deleteWishList(@PathVariable("id") Integer id) {
    return wishListService.deleteWishListById(id);
  }
}
