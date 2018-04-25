package localhost.shadow.sql_tst02;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AddClients extends Activity{

    TextView test1;
    CheckBox chb;
    ConnectionClass connectionClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclient);

        test1 = (TextView)findViewById(R.id.textView);
        test1.setText("ტექსტის თვისებების შეცვლა");
        registerForContextMenu(test1);
        chb = (CheckBox)findViewById(R.id.chbExtMenu);
        connectionClass = new ConnectionClass();


        // получаем экземпляр элемента ListView
        ListView listView = (ListView)findViewById(R.id.listView);

        // определяем массив типа String
      /*  final String[] catNames = new String[] {
                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба"
        };

        // используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, catNames);

        listView.setAdapter(adapter);  */

        fillAll fill = new fillAll();
        fill.execute("");
    }

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
     /*   StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        test1.setText(sb.toString());
    */
        return super.onOptionsItemSelected(item);
    }

    public class fillAll extends AsyncTask<String,String,String>{

        ProgressBar pbbar = (ProgressBar)findViewById(R.id.pbbar);
        ListView listView = (ListView)findViewById(R.id.listView);

  /*      @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
           /// Toast.makeText(AddClients.this,r,Toast.LENGTH_SHORT).show();
        }  */


        @Override
        protected String doInBackground(String... params){
            ArrayList<HashMap<String, String>> client = new ArrayList<HashMap<String, String>>();
            try{
                Connection con = connectionClass.CONN();
                if (con == null) {
                    String z = "Error in connection with SQL server";
                }  else {


                    String query = " SELECT TOP 10 Acc AS account, Acc_nu AS name FROM Accounts";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);


                    if(rs.next())
                    {
                        HashMap<String,String> mapp = new HashMap<>();
                        mapp.put("account", rs.getString("account"));
                        mapp.put("name", rs.getString("name"));
                        client.add(mapp);
                    }

                    /// тут был адаптер )))))
////////////////////////
                   /// listView.setAdapter(adapter);

                }

            }
            catch (Exception ex)
            {
                Toast.makeText(AddClients.this,"Exceptions",Toast.LENGTH_SHORT).show();
            }
            ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<>(AddClients.this, R.layout.list_item, client);
listView.setAdapter(adapter);

        return "";
        } /// end of doInBackground


    }// end of  class fillAll

}
