package ru.skillbox.a16_lists_1.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.skillbox.a16_lists_1.Vehicle

class VehicleAdapter(
    private val onItemClick: (id: Long, linkForPhoto: String) -> Unit
) : AsyncListDifferDelegationAdapter<Vehicle>(VehiclesDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(CarAdapterDelegate(onItemClick))
            .addDelegate(SelfDrivigCarAdapterDelegate(onItemClick))
    }

    class VehiclesDiffUtilCallback : DiffUtil.ItemCallback<Vehicle>() {
        override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            return when {
                oldItem is Vehicle.Car && newItem is Vehicle.Car -> oldItem.id == newItem.id
                oldItem is Vehicle.SelfDrivingCar && newItem is Vehicle.SelfDrivingCar -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            return oldItem == newItem
        }
    }

}