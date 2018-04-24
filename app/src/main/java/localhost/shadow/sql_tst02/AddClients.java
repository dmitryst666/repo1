package localhost.shadow.sql_tst02;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddClients extends Activity{

    TextView test1;
    CheckBox chb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclient);

        test1 = (TextView)findViewById(R.id.textView);
        test1.setText("fndljg hgo oug horg erogoi og oiurogu orug ourogiurei gureuog rhghlgrugh984h iigreuhg 48 8934 t983 t0480 098t 40t04 t0948t094 308");
        registerForContextMenu(test1);
        chb = (CheckBox)findViewById(R.id.chbExtMenu);
    }


    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_12 = 4;
    final int MENU_SIZE_14 = 5;
    final int MENU_SIZE_18 = 6;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
                 menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");

                menu.add(0, MENU_SIZE_12, 0, "12");
                menu.add(0, MENU_SIZE_14, 0, "14");
                menu.add(0, MENU_SIZE_18, 0, "18");


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
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        test1.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                test1.setTextColor(Color.RED);
                break;
            case MENU_COLOR_GREEN:
                test1.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_BLUE:
                test1.setTextColor(Color.BLUE);
                break;
// пункты меню для tvSize
            case MENU_SIZE_12:
                test1.setTextSize(12);
                break;
            case MENU_SIZE_14:
                test1.setTextSize(14);
                break;
            case MENU_SIZE_18:
                test1.setTextSize(18);
                break;
        }
        return super.onContextItemSelected(item);
    }


}
