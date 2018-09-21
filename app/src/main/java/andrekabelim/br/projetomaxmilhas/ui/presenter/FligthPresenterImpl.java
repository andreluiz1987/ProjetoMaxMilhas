package andrekabelim.br.projetomaxmilhas.ui.presenter;

import java.util.List;

import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.view.FligthView;

public class FligthPresenterImpl implements FligthPresenter {

    FligthView fligthView;
    Data dataFligth;

    public FligthPresenterImpl(FligthView fligthView){
        this.fligthView = fligthView;
    }

    public void setDataFligth(Data dataFligth){
        this.dataFligth = dataFligth;
    }

    @Override
    public void loadFligths(int size) {

    }

}
