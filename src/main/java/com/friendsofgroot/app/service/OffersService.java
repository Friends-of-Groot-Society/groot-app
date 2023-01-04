package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.Offer;

import java.util.List;
public interface OffersService {
    public Offer createOffer(Offer o);
    public Offer getOffer(int id);
    public List<Offer> getAllOffers();
    public List<Offer> getAllOffersCust(String username);
    public boolean updateOffer(Offer change);
    public boolean deleteOffer(int id);
    public boolean rejectOtherOffers(Offer rejectionChanges);

}
