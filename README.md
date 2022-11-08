# Employee-List
used technologies spring boot, spring data jpa, Thymeleaf etc

export const Convert = ({obj}) => {
  if (obj[0] instanceof Array) {
    return <div>{obj.map((value,n) => <CreateTable arr={value} key={n}/>)}</div>;
  }
  return (
    <div>
      {obj.map((value) =>
        Object.keys(value).map((r,n) => (<div key={n}>
          <h4>{r}</h4>
          <CreateTable arr={JSON.parse(value[r])} key={n}/>
          </div>)
        )
      )}
    </div>
  );
};
const CreateTable = ({arr}) => {
    if(arr[0]===undefined) return;
  const keys = Object.keys(arr[0]).map(k=>k)
  return (
    <table>
      <thead><tr>{keys.map((h,n) =><th key={n}>{h}</th>)}</tr></thead>
      <tbody>
        {arr.map((obj,n) => <tr key={n}>{keys.map((h,l) =><td key={l}>{obj[h]}</td>)}</tr>)}
      </tbody>
    </table>
  );
};
