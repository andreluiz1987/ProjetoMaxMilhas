package andrekabelim.br.projetomaxmilhas.ui.view;

import java.util.ArrayList;
import java.util.List;

import andrekabelim.br.projetomaxmilhas.ui.models.Data;
import andrekabelim.br.projetomaxmilhas.ui.models.OnWardFlight;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void navigateToFligthPage(ArrayList<OnWardFlight> data);
    void showAlert(String message);
}
