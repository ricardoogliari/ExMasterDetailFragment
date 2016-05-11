package curso.mpgo.com.exmasterdetailfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ricardoogliari on 5/11/16.
 */
public class DetalheFragment extends Fragment {

    private TextView txtTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_detalhe, null);
        txtTime = (TextView)view.findViewById(R.id.txtTime);
        return view;
    }

    public void setText(String time){
        txtTime.setText(time);
    }
}
