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

import com.shopping.laptopshopping.entity.Feature;
import com.shopping.laptopshopping.service.FeatureService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class FeatureResource {

  @Autowired FeatureService featureService;

  @GetMapping("feature")
  public List<Feature> getFeatures() {
    return featureService.getAllFeatures();
  }

  @GetMapping("feature/{id}")
  public Feature getFeatureById(@PathVariable("id") Integer id) {
    return featureService.getFeatureById(id);
  }

  @PostMapping("feature")
  public Feature saveFeature(@RequestBody Feature feature) {
    return featureService.saveOrUpdateFeature(feature);
  }

  @PutMapping("feature")
  public Feature updateFeature(@RequestBody Feature feature) {
    return featureService.saveOrUpdateFeature(feature);
  }

  @DeleteMapping("feature/{id}")
  public boolean deleteFeature(@PathVariable("id") Integer id) {
    return featureService.deleteFeatureById(id);
  }
}
