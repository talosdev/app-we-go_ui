package app.we.go.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T> The type of the objects that the adapter handler
 * @param <VH> The ViewHolder type
 */
public abstract class ListBasedRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected final ArrayList<T> data = new ArrayList<>();
    private final int modelLayout;

    protected ListBasedRecyclerViewAdapter(int modelLayout) {
        this.modelLayout = modelLayout;
    }


    public List<T> getData() {
        return data;
    }

    public void addData(List<T> dataToAdd) {
        data.addAll(dataToAdd);
        notifyDataSetChanged();
    }

    public void add(T item) {
        data.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    /**
     * Default implementation that assumes that the ViewHolder class has a constructor with a single
     * argument of type {@link View}
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(viewType, parent, false);

        return onCreateViewHolder(view);


//        View view = inflater.inflate(viewType, parent, false);
//
//        try {
//            Constructor<VH> constructor = viewHolderClass.getConstructor(View.class);
//            return constructor.newInstance(view);
//        } catch (NoSuchMethodException e) {
//            Log.e("EXC", viewHolderClass.getName());
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }


    protected abstract VH onCreateViewHolder(View view);


    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * We are using the convention that the view type returned by this method will be
     * the resource id of the view to be used by that item.
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return modelLayout;
    }
}
