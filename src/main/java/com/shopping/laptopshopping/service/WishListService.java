package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.WishList;
import com.shopping.laptopshopping.repository.WishListRepository;

@Service
public class WishListService {

  @Autowired WishListRepository wishListRepo;

  public List<WishList> getAllWishLists() {
    List<WishList> wishLists = new ArrayList<>();
    try {
      wishLists = wishListRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all WishLists: " + exception);
    }
    return wishLists;
  }

  public WishList getWishListById(Integer id) {
    WishList wishList = null;
    try {
      Optional<WishList> wishListOptional = wishListRepo.findById(id);
      if (wishListOptional.isPresent()) {
        wishList = wishListOptional.get();
      } else {
        System.out.println("WishList not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding WishList: " + exception);
    }
    return wishList;
  }

  public WishList saveOrUpdateWishList(WishList wishList) {
    WishList savedWishList = null;
    try {
      savedWishList = wishListRepo.save(wishList);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating WishList: " + exception);
    }
    return savedWishList;
  }

  public boolean deleteWishListById(Integer id) {
    try {
      wishListRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting WishList: " + exception);
      return false;
    }
  }
}
