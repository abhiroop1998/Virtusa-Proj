package com.adminportal.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cloth {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String productCode;	
	private String soldBy;		
	private String name;
	
	@Column(columnDefinition="text")
	private String description;	
	@Column(columnDefinition="text")
	private String details;	
	
	private double cost;	
	private double previousCost;	
	private String sizeAvailable;	
	private String material;
	private String care;	
	private String fabric;	
	private String fit;
	private String type;
	private String length;	
	private String mainTrend;	
	private String multipackSet;	
	private String neck;	
	private String occasion;
	private String pattern;	
	private String printOrPatternType;	
	private String sleeveLength;	
	private String sleeveStyling;	
	private String washCare;	
	private String gender;
	private boolean active = true;
	
	private int stockNumber;
	
	@Transient
	private MultipartFile clothImage;

	@OneToMany(mappedBy="cloth")
	@JsonIgnore
	private List<ClothToCartItem> clothToCartItemList;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPreviousCost() {
		return previousCost;
	}

	public void setPreviousCost(double previousCost) {
		this.previousCost = previousCost;
	}

	public String getSizeAvailable() {
		return sizeAvailable;
	}

	public void setSizeAvailable(String sizeAvailable) {
		this.sizeAvailable = sizeAvailable;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMainTrend() {
		return mainTrend;
	}

	public void setMainTrend(String mainTrend) {
		this.mainTrend = mainTrend;
	}

	public String getMultipackSet() {
		return multipackSet;
	}

	public void setMultipackSet(String multipackSet) {
		this.multipackSet = multipackSet;
	}

	public String getNeck() {
		return neck;
	}

	public void setNeck(String neck) {
		this.neck = neck;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPrintOrPatternType() {
		return printOrPatternType;
	}

	public void setPrintOrPatternType(String printOrPatternType) {
		this.printOrPatternType = printOrPatternType;
	}

	public String getSleeveLength() {
		return sleeveLength;
	}

	public void setSleeveLength(String sleeveLength) {
		this.sleeveLength = sleeveLength;
	}

	public String getSleeveStyling() {
		return sleeveStyling;
	}

	public void setSleeveStyling(String sleeveStyling) {
		this.sleeveStyling = sleeveStyling;
	}

	public String getWashCare() {
		return washCare;
	}

	public void setWashCare(String washCare) {
		this.washCare = washCare;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public MultipartFile getClothImage() {
		return clothImage;
	}

	public void setClothImage(MultipartFile clothImage) {
		this.clothImage = clothImage;
	}

	public List<ClothToCartItem> getClothToCartItemList() {
		return clothToCartItemList;
	}

	public void setClothToCartItemList(List<ClothToCartItem> clothToCartItemList) {
		this.clothToCartItemList = clothToCartItemList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
