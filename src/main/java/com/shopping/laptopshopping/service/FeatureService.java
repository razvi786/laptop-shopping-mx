package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Feature;
import com.shopping.laptopshopping.repository.FeatureRepository;

@Service
public class FeatureService {

  @Autowired FeatureRepository featureRepo;

  public List<Feature> getAllFeatures() {
    List<Feature> features = new ArrayList<>();
    try {
      features = featureRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Features: " + exception);
    }
    return features;
  }

  public Feature getFeatureById(Integer id) {
    Feature feature = null;
    try {
      Optional<Feature> featureOptional = featureRepo.findById(id);
      if (featureOptional.isPresent()) {
        feature = featureOptional.get();
      } else {
        System.out.println("Feature not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Feature: " + exception);
    }
    return feature;
  }

  public Feature saveOrUpdateFeature(Feature feature) {
    Feature savedFeature = null;
    try {
      savedFeature = featureRepo.save(feature);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Feature: " + exception);
    }
    return savedFeature;
  }

  public boolean deleteFeatureById(Integer id) {
    try {
      featureRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Feature: " + exception);
      return false;
    }
  }
}
