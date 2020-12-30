package org.packt.supplier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@NamedQueries({
	@NamedQuery(name="SearchRS.findAll",query="select s from SearchRS s")
})
@Table(name="flight")
public class SearchRS implements Comparable<SearchRS>,Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	private Date validDate;
	private String departTime;
	private Double flightDuration;
	private Float fare;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	
	public Double getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public Float getFare() {
		return fare;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getDepartTime() {
		return departTime;
	}
	@Override
	public int compareTo(SearchRS o) {
		
		int result = 0;
		
		if(o.fare > this.fare)
			result = 1;
		else if(o.fare < this.fare)
			result = -1;	
		
		return result;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
