package com.example.swipedelete

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    private var icon: Drawable? = null
    private var background: ColorDrawable? = null
    lateinit var courseRV: RecyclerView

    lateinit var courseRVAdapter: swipe_adapter
    lateinit var courseList: ArrayList<CourseRvModel>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // our views with their ids.
        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
        courseList = ArrayList()

        // on below line we are initializing our adapter
        courseRVAdapter = swipe_adapter(courseList, this)

        // on below line we are setting adapter
        // to our recycler view.
        courseRV.adapter = courseRVAdapter

//         on below line we are adding data to our list
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
        courseList.add(CourseRvModel("Order Delivered Rider has reached\nthe pick up",
            R.drawable.rectangle_2919__1_))
//        courseList.add(CourseRvModel("Android Development", R.drawable.ic_baseline_airplanemode_active_24))
//        courseList.add(CourseRvModel("C++ Development", R.drawable.c))
//        courseList.add(CourseRvModel("Java Development", R.drawable.java))
//        courseList.add(CourseRvModel("Python Development", R.drawable.python))
//        courseList.add(CourseRvModel("JavaScript Development", R.drawable.js))


        // on below line we are notifying adapter
        // that data has been updated.
        courseRVAdapter.notifyDataSetChanged()

        // on below line we are creating a method to create item touch helper
        // method for adding swipe to delete functionality.
        // in this we are specifying drag direction and position to right
        // on below line we are creating a method to create item touch helper
        // method for adding swipe to delete functionality.
        // in this we are specifying drag direction and position to right
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,

                ): Boolean {

                // this method is called
                // when the item is moved.
                return false

            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                // this method is called when we swipe our item to right direction.
                // on below line we are getting the item at a particular position.
                val deletedCourse: CourseRvModel =
                    courseList.get(viewHolder.adapterPosition)
                background = ColorDrawable(Color.GREEN)
                ;
                // below line is to get the position
                // of the item at that position.
                val position = viewHolder.adapterPosition


                // this method is called when item is swiped.
                // below line is to remove item from our array list.
                courseList.removeAt(viewHolder.adapterPosition)


                // below line is to notify our item is removed from adapter.
                courseRVAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                ;
                // below line is to display our snackbar with action.
                // below line is to display our snackbar with action.
                // below line is to display our snackbar with action.
                Snackbar.make(courseRV, "Deleted " + deletedCourse.courseName, Snackbar.LENGTH_LONG)
                    .setAction(
                        "Undo",
                        View.OnClickListener {
                            // adding on click listener to our action of snack bar.
                            // below line is to add our item to array list with a position.
                            courseList.add(position, deletedCourse)

//                             icon = ContextCompat.getDrawable(swipe_adapter.(),
//                                R.drawable.ic_baseline_delete_24)
                         ;
                            // below line is to notify item is
                            // added to our adapter class.
                            courseRVAdapter.notifyItemInserted(position)

                        }).show()
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(courseRV)
    }


       ;
        }



