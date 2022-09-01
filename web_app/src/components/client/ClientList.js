import ClientItem from "./ClientItem";

function ClientList(props, clients, loading) {
    if(loading) {
      return <h2>Loading...</h2>
    }
    return (
        <div>
            {props.clients?.map((client) => (<ClientItem
              key={client.id}
              onDelete={props.onDelete}
              id={client.id}
              client={client}
            />
          ))
        }
        </div>
    );
}

export default ClientList;