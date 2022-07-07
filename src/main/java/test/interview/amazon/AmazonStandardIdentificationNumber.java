package test.interview.amazon;

import java.util.*;

public class AmazonStandardIdentificationNumber {

    private Map<String, ArrayList<Campaigns>> lstCamp = new HashMap<>();

    public AmazonStandardIdentificationNumber() {
        ArrayList<Campaigns> campaigns = new ArrayList<>();
        Campaigns camp = new Campaigns();
        camp.setCampaignsName("Amazon Big Sale day");
        camp.setStartDate(new Date());
        camp.setEndDate(new Date());
        campaigns.add(camp);
        lstCamp.put("B098RKWHHZ", campaigns);
    }

    public ArrayList<Campaigns> getListCamp(ASIN asin, Date startDate, Date endDate) {
        if (asin == null) {
            return new ArrayList<>();
        }

        if (startDate.after(endDate)) {
            return new ArrayList<>();
        }

        ArrayList<Campaigns> listCampForAsin = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Campaigns>> map : lstCamp.entrySet()) {
            if (Objects.equals(map.getKey(), asin.getAsin())) {
                ArrayList<Campaigns> camp = map.getValue();
                for (Campaigns c : camp) {
                    if (c.getStartDate().after(startDate) && c.getEndDate().before(endDate)) {
                        listCampForAsin.add(c);
                    }
                }
            }
        }
        return listCampForAsin;
    }

    public ArrayList<ASIN> getListAsin(Campaigns campaigns) {
        if (campaigns == null) {
            return new ArrayList<>();
        }
        ArrayList<ASIN> listAsinForCamping = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Campaigns>> map : lstCamp.entrySet()) {
            ArrayList<Campaigns> camp = map.getValue();
            for (Campaigns c : camp) {
                if (campaigns.getCampaignsName().equals(campaigns.getCampaignsName()) &&
                        c.getStartDate().after(campaigns.getStartDate()) &&
                        c.getEndDate().before(campaigns.getEndDate())) {
                    ASIN asin = new ASIN();
                    asin.setAsin(map.getKey());
                    listAsinForCamping.add(asin);
                }
            }
        }
        return listAsinForCamping;
    }
}
