package com.basic.angular.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    @UpdateTimestamp
    private LocalDate checkInDate;

    private Boolean checkedIn;

    private String baggage;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private List<Child> children;

    public Passenger()
    {
        children = new ArrayList<>();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public List<Child> getChildren()
    {
        return children;
    }

    public void setChildren(List<Child> children)
    {
        this.children = children;
    }

    public Boolean getCheckedIn()
    {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn)
    {
        this.checkedIn = checkedIn;
    }

    public LocalDate getCheckInDate()
    {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate)
    {
        this.checkInDate = checkInDate;
    }

    public String getBaggage()
    {
        return baggage;
    }

    public void setBaggage(String baggage)
    {
        this.baggage = baggage;
    }
}
