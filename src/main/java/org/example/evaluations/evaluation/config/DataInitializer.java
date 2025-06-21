package org.example.evaluations.evaluation.config;

import org.example.evaluations.evaluation.models.*;
import org.example.evaluations.evaluation.repos.CategoryRepo;
import org.example.evaluations.evaluation.repos.ProductRepo;
import org.example.evaluations.evaluation.repos.SubCategoryRepo;
import org.example.evaluations.evaluation.repos.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Autowired
    private ImageRepo imageRepo;

    @Override
    public void run(String... args) throws Exception {
        // Create categories
        Category electronics = new Category();
        electronics.setTitle("Electronics");
        electronics.setState(State.ACTIVE);
        electronics = categoryRepo.save(electronics);

        Category clothing = new Category();
        clothing.setTitle("Clothing");
        clothing.setState(State.ACTIVE);
        clothing = categoryRepo.save(clothing);

        // Create subcategories
        SubCategory smartphones = new SubCategory();
        smartphones.setName("Smartphones");
        smartphones.setDescription("Mobile phones and accessories");
        smartphones.setCategory(electronics);
        smartphones.setState(State.ACTIVE);
        subCategoryRepo.save(smartphones);

        SubCategory laptops = new SubCategory();
        laptops.setName("Laptops");
        laptops.setDescription("Portable computers");
        laptops.setCategory(electronics);
        laptops.setState(State.ACTIVE);
        subCategoryRepo.save(laptops);

        SubCategory mensClothing = new SubCategory();
        mensClothing.setName("Men's Clothing");
        mensClothing.setDescription("Clothing for men");
        mensClothing.setCategory(clothing);
        mensClothing.setState(State.ACTIVE);
        subCategoryRepo.save(mensClothing);

        SubCategory womensClothing = new SubCategory();
        womensClothing.setName("Women's Clothing");
        womensClothing.setDescription("Clothing for women");
        womensClothing.setCategory(clothing);
        womensClothing.setState(State.ACTIVE);
        subCategoryRepo.save(womensClothing);

        // Create products
        Product iphone = new Product();
        iphone.setName("iPhone 15");
        iphone.setCategory(electronics);
        iphone.setState(State.ACTIVE);
        iphone = productRepo.save(iphone);

        Product macbook = new Product();
        macbook.setName("MacBook Pro");
        macbook.setCategory(electronics);
        macbook.setState(State.ACTIVE);
        macbook = productRepo.save(macbook);

        Product tshirt = new Product();
        tshirt.setName("Cotton T-Shirt");
        tshirt.setCategory(clothing);
        tshirt.setState(State.ACTIVE);
        tshirt = productRepo.save(tshirt);

        Product dress = new Product();
        dress.setName("Summer Dress");
        dress.setCategory(clothing);
        dress.setState(State.ACTIVE);
        dress = productRepo.save(dress);

        // Create images
        Image iphoneImage1 = new Image();
        iphoneImage1.setDescriptiveName("iPhone 15 Front View");
        iphoneImage1.setResolution("1920x1080");
        iphoneImage1.setSizeInKb(512L);
        iphoneImage1.setProduct(iphone);
        iphoneImage1.setState(State.ACTIVE);
        imageRepo.save(iphoneImage1);

        Image iphoneImage2 = new Image();
        iphoneImage2.setDescriptiveName("iPhone 15 Back View");
        iphoneImage2.setResolution("1920x1080");
        iphoneImage2.setSizeInKb(480L);
        iphoneImage2.setProduct(iphone);
        iphoneImage2.setState(State.ACTIVE);
        imageRepo.save(iphoneImage2);

        Image macbookImage = new Image();
        macbookImage.setDescriptiveName("MacBook Pro Side View");
        macbookImage.setResolution("2560x1440");
        macbookImage.setSizeInKb(1024L);
        macbookImage.setProduct(macbook);
        macbookImage.setState(State.ACTIVE);
        imageRepo.save(macbookImage);

        Image tshirtImage = new Image();
        tshirtImage.setDescriptiveName("Cotton T-Shirt Model Shot");
        tshirtImage.setResolution("1200x800");
        tshirtImage.setSizeInKb(256L);
        tshirtImage.setProduct(tshirt);
        tshirtImage.setState(State.ACTIVE);
        imageRepo.save(tshirtImage);

        Image dressImage = new Image();
        dressImage.setDescriptiveName("Summer Dress Outdoor Shot");
        dressImage.setResolution("1600x1200");
        dressImage.setSizeInKb(768L);
        dressImage.setProduct(dress);
        dressImage.setState(State.ACTIVE);
        imageRepo.save(dressImage);

        System.out.println("Test data initialized successfully!");
    }
} 