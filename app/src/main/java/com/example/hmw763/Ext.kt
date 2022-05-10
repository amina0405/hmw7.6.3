package com.example.hmw763

    import android.annotation.SuppressLint
    import android.app.AlertDialog
    import android.content.Context
    import android.view.LayoutInflater
    import android.widget.Toast
    import android.widget.Toast.LENGTH_SHORT
    import androidx.appcompat.app.AppCompatActivity
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.FragmentActivity
    import com.example.hmw763.databinding.FragmentMainBinding

    fun Context.showToast(msg: String){
        Toast.makeText(this,msg,LENGTH_SHORT).show()
    }
    fun AppCompatActivity.launchFragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().add(R.id.container,fragment).commit()
    }
    fun FragmentActivity.replaceFragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(" ").commit()
    }

    fun Fragment.showAlert(title: String, items: Int, onClick: ((pos: Int) -> Unit?)? = null) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(title).setItems(
            items
        ) { p0, pos ->
            if (onClick != null) {
                onClick(pos)
            }
        }.create().show()
}