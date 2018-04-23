package localhost.shadow.sql_tst02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddClients extends Activity{

TextView test1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclient);

        test1 = (TextView)findViewById(R.id.textView);
        test1.setText("fndljg hgo oug horg erogoi og oiurogu orug ourogiurei gureuog rhghlgrugh984h iigreuhg 48 8934 t983 t0480 098t 40t04 t0948t094 308");




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("Refresh");
        menu.add("Add new");
        menu.add("Remove");
        menu.add("Close");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

}
