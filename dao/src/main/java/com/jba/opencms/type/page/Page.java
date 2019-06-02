package com.jba.opencms.type.page;

import com.jba.opencms.type.base.BaseTypeSimpleKey;
import com.jba.opencms.type.image.Image;
import com.jba.opencms.type.user.Authority;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "page")
public class Page extends BaseTypeSimpleKey<Page> {

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "VISIBLE", nullable = false)
    private Boolean visible;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "page_authority",
            joinColumns = {@JoinColumn(name = "FK_AUTHORITY_ID")},
            inverseJoinColumns = {@JoinColumn(name="FK_PAGE_ID")}
    )
    @ToString.Exclude
    private List<Authority> pageAuthorities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "subpage",
            joinColumns = {@JoinColumn(name = "FK_PAGE_ID_CHILD")},
            inverseJoinColumns = {@JoinColumn(name = "FK_PAGE_ID_PARENT")}
    )
    @ToString.Exclude
    private List<Page> subpages = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "image_page",
            joinColumns = {@JoinColumn(name = "FK_IMAGE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FK_PAGE_ID")}
    )
    @ToString.Exclude
    private List<Image> images = new ArrayList<>();

    public void addAuthority(Authority authority){
        if(!pageAuthorities.contains(authority)) {
            pageAuthorities.add(authority);
        }
        else throw new IllegalArgumentException("This page already contains authority: "+authority.getRole());
    }

    public String getAuthoritiesAsString(){
        if(pageAuthorities.size()>0)
            return pageAuthorities.stream().map(a -> a.getRole().name()).collect(Collectors.joining(", "));
        else return "";
    }
}