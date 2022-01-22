package com.example.al;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.animal_Row_Holder>
{
    ArrayList<Animal>animal_data;
    Context context;
 myInterface myclickinterface;

public AnimalAdapter(ArrayList<Animal>animal_data,Context context,myInterface myclickinterface)
{
this.animal_data=animal_data;
this.context=context;
this.myclickinterface=myclickinterface;
}


    @NonNull

    @Override
    public animal_Row_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false);
        return new animal_Row_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  animal_Row_Holder holder, int position) {
holder.txtanimal.setText(animal_data.get(position).getName());
holder.animalimage.setImageResource(animal_data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animal_data.size();
    }

    class animal_Row_Holder extends RecyclerView.ViewHolder

{
    TextView txtanimal;
    ImageView animalimage;
    public animal_Row_Holder(@NonNull  View itemView) {
        super(itemView);
        txtanimal=itemView.findViewById(R.id.text_animal_name);
        animalimage=itemView.findViewById(R.id.img_animal);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  myclickinterface.onItemClick(getAdapterPosition());
              }
          });
    }

}
interface  myInterface
{
    void onItemClick(int postionAnimal);
}


}
